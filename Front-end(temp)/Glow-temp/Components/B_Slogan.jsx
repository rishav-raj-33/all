import canny from '/src/assets/canny.jpg';

import { useState } from 'react';
import { useEffect } from 'react';
import B_SloganSkeleton from './Skeleton/B_SloganSkeleton';

function B_Slogan() {

    const [isDelay, setIsDelay] = useState(true);


    useEffect(() => {
        const timer = setTimeout(() => {
            setIsDelay(false);
        }, 3000);

        return () => clearTimeout(timer);
    }, []);


    return (

        <>

        {
                isDelay ? (<B_SloganSkeleton />) :
                (<div className="container-fluid" id="slogan">

                    <h1 className="text-center" id="slogan-h1">Exploring the intersection of</h1> <h1 className="text-center" id="tech">Technologies </h1>
                    <h5 className="text-center" id="slogan-h5">Push the limits of innovation by combining popular technologies </h5>

                    <div className="row justify-content-evenly" id="filter-description-div">
                        <div className="col-md-6" id="photo-content">
                            <img id='image' src={canny}></img>
                        </div>
                        <div className="col-md--6" id='description-content'>
                            <h1 id='filter-heading'>The Artistic Touch of Canny Edge Detection</h1>
                            <p id='filter-description'>The Canny Edge Detection filter is like a magic tool for your photos, bringing out the edges and details in a stunning way. It works by highlighting the transitions between light and dark areas, creating a sharp and clean outline of objects in the image. This filter gives your picture a bold, almost sketch-like look, perfect for emphasizing structure and shapes. Whether you’re editing landscapes, portraits, or abstract shots, the Canny filter adds a dramatic touch, making the details pop and giving your photo a unique, artistic feel.</p>


                        </div>

                    </div>



                </div>)
        }

        

        </>

    )







}



export default B_Slogan;