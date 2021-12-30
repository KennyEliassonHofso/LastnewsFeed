let articles = [];
getArticles()

async function getArticles() {
    let result = await fetch("/articles");
    articles = await result.json();
    
    console.log(articles);
    
    renderArticles();
}

function renderArticles() {
    let article = document.querySelector("#article");

    article.innerHTML = "";

    for(let article of articles) { 
        //let date = new Date(article.timestamp).toLocaleString();

        let articleLi = `
        <li>
            <Img src="${article.imageURL1}" alt="article-image">
            id: ${article.id} <br>
            <h3>${article.title}</h3>

            <p>${article.content}</p>
            </li> <br>

            `;

        articleLi.innerHTML += articleLi;

    }   
}

async function createArticle(e) {
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
            imageURL1: imageURL1,
            imageUrl2: imageUrl2
        }

        let result = await fetch("/articles", {
                method: "POST",
                body: JSON.stringify(post)
            });

              posts.push(article)

                console.log(await result.text())
            }
