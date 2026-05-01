package io.github.notwrench.emailsender

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etSubject: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var btnAttach: Button

    private var fileUri: Uri? = null

    // Modern way to handle activity results
    private val selectFileLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        fileUri = uri
        if (uri != null) {
            Toast.makeText(this, "File Attached", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etSubject = findViewById(R.id.etSubject)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnAttach = findViewById(R.id.btnAttach)

        // Attach file
        btnAttach.setOnClickListener {
            selectFileLauncher.launch("*/*")
        }

        // Send email
        btnSend.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val subject = etSubject.text.toString().trim()
            val message = etMessage.text.toString().trim()

            if (email.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sendEmail(email, subject, message)
        }
    }

    private fun sendEmail(email: String, subject: String, message: String) {
        val intent: Intent = if (fileUri != null) {
            Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
                putExtra(Intent.EXTRA_STREAM, fileUri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
        } else {
            Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }
        }

        try {
            startActivity(Intent.createChooser(intent, "Send Email"))
        } catch (e: Exception) {
            Toast.makeText(this, "No Email App Found", Toast.LENGTH_SHORT).show()
        }
    }
}
