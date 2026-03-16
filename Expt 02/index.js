document.getElementById('registrationForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const firstName = document.getElementById('firstName').value.trim();
    const lastName = document.getElementById('lastName').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;
    const mobile = document.getElementById('mobile').value.trim();
    const address = document.getElementById('address').value.trim();

    if (!validateFirstName(firstName)) {
        return;
    }

    if (!validatePassword(password)) {
        return;
    }

    if (!validateEmail(email)) {
        return;
    }

    if (!validateMobile(mobile)) {
        return;
    }

    if (!validateLastName(lastName)) {
        return;
    }

    if (!validateAddress(address)) {
        return;
    }

    alert('Form submitted successfully!');
    this.reset();
});

function validateFirstName(firstName) {
    const alphabetRegex = /^[A-Za-z]+$/;

    if (!alphabetRegex.test(firstName)) {
        alert('First Name must contain only alphabets.');
        return false;
    }

    if (firstName.length < 6) {
        alert('First Name must be at least 6 characters long.');
        return false;
    }

    return true;
}

function validatePassword(password) {
    if (password.length < 6) {
        alert('Password must be at least 6 characters long.');
        return false;
    }

    return true;
}

function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        alert('Invalid email format. Please enter a valid email address (e.g., name@domain.com).');
        return false;
    }

    return true;
}

function validateMobile(mobile) {
    const digitRegex = /^\d{10}$/;

    if (!digitRegex.test(mobile)) {
        alert('Mobile Number must contain exactly 10 digits with no alphabets or special characters.');
        return false;
    }

    return true;
}

function validateLastName(lastName) {
    if (lastName === '') {
        alert('Last Name cannot be empty.');
        return false;
    }

    return true;
}

function validateAddress(address) {
    if (address === '') {
        alert('Address cannot be empty.');
        return false;
    }

    return true;
}
