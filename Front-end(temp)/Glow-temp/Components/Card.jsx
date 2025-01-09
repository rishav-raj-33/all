import img from '/src/assets/default_image.png';

import { useEffect } from 'react';
import { useState } from 'react'



function Card() {

    let [product, setProduct] = useState([]);
    let [file,setFile] =useState(null);
    const [imageData, setImageData] = useState();
    const [dataFetched, setDataFetched] = useState(false);


    useEffect(() => {
        fetch('http://localhost:8080/api/filter/all')
            .then(res => res.json())
            .then((data) => {
                setProduct(data);
                setDataFetched(true); // Prevent re-fetch
                const imageType = 'image/png'; 
                const base64String = product.filterImagePath; 
                const formattedBase64 = `data:${imageType};base64,${base64String}`;
                setImageData(formattedBase64);

            }
            )
            .catch((error) => {
                console.log(error);
            })
    }, [dataFetched]);


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
                            
                            <div className="card" id='card-content'>
                                    <img src={`data:image/jpeg;base64,${element.filterImagePath}`} className="card-img-top img-fluid" alt="processing image" id="process-logo" />
                                <div className="card-body justify-content-center">
                                        <h5 className="card-title filter-content-card">{element.filterName}</h5>
                                        <p className="card-text text-start filter-content-card" >{element.filterDescription}
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