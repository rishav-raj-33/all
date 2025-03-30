

import { useEffect } from 'react';
import { useState } from 'react';
import axios from "axios";
import Loader from './Loader';



function Card() {

    let [product, setProduct] = useState([]);
    let [file, setFile] = useState(null);
    let [id, setId] = useState(null);
    const [imageData, setImageData] = useState();
    const [dataFetched, setDataFetched] = useState(false);
    const [isBlocked, setIsBlocked] = useState(false);


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


    function handleFile(event) {
        const selectedFile = event.target.files[0];
        const selectedId = event.target.id;
        if (selectedFile) {
            setFile(selectedFile);
            setId(selectedId);
            console.log(selectedFile);
            console.log(selectedId);
        }

    }

    async function Upload() {
        const formData = new FormData();
        formData.append("image", file); // Append the file to FormData

        try {
            setIsBlocked(true);
            const response = await axios.post("http://localhost:8080/api/apply/image/" + id, formData, {
                headers: {
                    "Content-Type": "multipart/form-data", // Specify that it's a file upload
                },
            });
            
            const getJpeg = response.data.filterImage;
            const getTxt = response.data.txtFile;
            const jpegBlob = base64ToBlob(getJpeg, 'image/jpeg');
            const txtBlob = base64ToBlob(getTxt, 'text/plain');
            const jpegFile = new File([jpegBlob], 'image.jpeg', { type: 'image/jpeg' });
            const txtFile = new File([txtBlob], 'file.txt', { type: 'text/plain' });
            downloadFile(jpegFile);
            downloadFile(txtFile)
            setIsBlocked(false);
            console.log(" File Downloading successfully...");
        } catch (error) {
            setIsBlocked(false);
            console.error("Error uploading file:", error);
        }
    }


    const base64ToBlob = (base64, mimeType) => {
        const byteCharacters = atob(base64);
        const byteArrays = [];

        for (let offset = 0; offset < byteCharacters.length; offset += 512) {
            const slice = byteCharacters.slice(offset, offset + 512);
            const byteNumbers = Array.from(slice).map((char) => char.charCodeAt(0));
            byteArrays.push(new Uint8Array(byteNumbers));
        }

        return new Blob(byteArrays, { type: mimeType });
    };


    const downloadFile = (file) => {
        const url = window.URL.createObjectURL(file);
        const a = document.createElement('a');
        a.href = url;
        a.download = file.name;
        a.click();
        window.URL.revokeObjectURL(url);
    };


    return (

        <>
            { isBlocked ? (<Loader/>) :
( <div className='container-fluid' id='card-main-div'>
            <div className="row justify-content-evenly" id='row-card'>
                {
                    product.map((element) => {
                        return (
                            <div className="col-md-3 mt-3" key={element.id} id='card-div'>

                                <div className="card" id='card-content'>
                                    <img src={`data:image/jpeg;base64,${element.filterImagePath}`} className="card-img-top img-fluid" alt="processing image" id="process-logo" />
                                    <div className="card-body justify-content-center">
                                        <h5 className="card-title filter-content-card">{element.filterName}</h5>
                                        <p className="card-text text-start filter-content-card" >{element.filterDescription}
                                        </p>
                                    </div>
                                    <input type="file" accept="image/jpeg, image/png" id={element.id} onChange={handleFile} />
                                    <button className='btn-hover' onClick={Upload}>Upload</button>

                                </div>
                            </div>
                        )

                    })


                }

            </div>
        </div>
)
}
</>
        
    )
}



export default Card;