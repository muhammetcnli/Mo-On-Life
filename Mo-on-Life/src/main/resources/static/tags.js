<script>

    let tags = [];

    function addTag(){
    let input = document.getElementById("tagInput");
    let tag = input.value.trim();

    if(tag !== "" && !tags.includes(tag)){
        tags.push(tag);
        updateTagList();
    }
    input.value = "";

    function updateTagList(){

    }
    }