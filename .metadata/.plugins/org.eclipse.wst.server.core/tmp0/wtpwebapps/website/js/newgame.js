function goToMain() {
    window.location.href = 'main.html';
}

function validateForm() {
    var name = document.forms["createAccountForm"]["name"].value;
    if (name.trim() === "") {
        alert("Write your name");
        return false;
    }

    // Generate a random sequence array
    var sequenceArray = generateRandomSequenceArray();

    // Save to local storage

    // Set the sequence value in the form before submission
    document.forms["createAccountForm"]["sequence"].value = JSON.stringify(sequenceArray);

    return true;
}

function generateRandomSequenceArray() {
    var sequenceArray = [];
    for (var i = 1; i <= 30; i++) {
        sequenceArray.push(i);
    }
    // Shuffle the array (you can use your own shuffle logic)
    sequenceArray = shuffleArray(sequenceArray);
    return sequenceArray;
}

function shuffleArray(array) {
    for (var i = array.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}

