import img from '/src/assets/default_image.png';


function Card() {


    return (
        <div className="card">
            <img src={img} className="card-img-top img-fluid" alt="processing image" id="process-logo" />
            <div className="card-body justify-content-center">
                <h5 className="card-title">Title</h5>
                <p className="card-text text-start">Lorem ipsum dolor sit amet consectetur adipisicing elit. A doloremque molestiae asperiores impedit aliquam reiciendis nihil vero error consectetur maxime fugiat repellat quo veritatis incidunt eum, totam eveniet tenetur? Quae.
                </p>
            </div>
            <button className="btn-hover" >Upload</button>

        </div>
    )
}



export default Card;