class Article {

    createArticle(e) {
        e.preventDefuault();
    
        let files = document.querySelector('input[type=file]').files; 
        let formData = new Formdata();
    
        for (let file of files) {
            formData.append ('files', file, file.name);
        }
    
        let uploadResult = await fetch ('/api/file-upload', {
            method: 'POST',
            body: formData
        });
    
        let imageUrl = await uploadResult.text();
    
        let titleInput = document.querySelector('#title');
        let contentInput = document.querySelector('#content');
    
        let article = {
            title: titleInput.value,
            content: contentInput.value,
            imageURL1: imageUrl[0],
            imageUrl2: imageUrl[1]
        }
    
        let result = await fetch("/articles", {
                method: "POST",
                body: JSON.stringify(post)
            });
    }
}