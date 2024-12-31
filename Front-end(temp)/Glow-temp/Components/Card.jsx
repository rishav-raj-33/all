import img from '/src/assets/default_image.png';

import { useEffect } from 'react';
import { useState } from 'react'



function Card() {

    let [product, setProduct] = useState([]);
    let [file,setFile] =useState(null);


    useEffect(() => {
        fetch('https://fakestoreapi.in/api/products')
            .then(res => res.json())
            .then((data) => {
                setProduct(data.products);

            }
            )
            .catch((error) => {
                console.log(error);
            })
    })


    function handleFile(event){
        const selectedFile = event.target.files[0];
        if (selectedFile) {
            setFile(selectedFile); 
            console.log(selectedFile);
        }

    }


    return (


        <div className='container-fluid' id='card-main-div'>
            <div className="row justify-content-evenly" id='row-card'>
                {
                    product.map((element)=>{
                        return(
                        <div className="col-md-3 mt-3" key={element.id} id='card-div'>
                            <div className="card">
                                <img src={img} className="card-img-top img-fluid" alt="processing image" id="process-logo" />
                                <div className="card-body justify-content-center">
                                    <h5 className="card-title filter-content-card">{element.title}</h5>
                                    <p className="card-text text-start filter-content-card" >Lorem ipsum dolor sit amet consectetur adipisicing elit. A doloremque molestiae asperiores impedit aliquam reiciendis nihil vero error consectetur maxime fugiat repellat quo veritatis incidunt eum, totam eveniet tenetur? Quae.
                                    </p>
                                </div>
                                        <input type="file" id="fileInput" className='btn-hover' onChange={handleFile}/>
                                    
                            </div>
                        </div>
                        )

                    })
                    

                }
            
           

             

            </div>
        </div>

    )
}



export default Card;