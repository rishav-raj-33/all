import { useState } from 'react';
import { useEffect } from 'react';
import TouchSkeleton from './Skeleton/TouchSkeleton';

function Touch() {



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

                isDelay ? (<TouchSkeleton />) :            
            
        (< div className = "container-fluid" id = "touch" >

            <div className="row justify-content-center">

                <div className="col-12" id="talk">
                    <h1 className="text-center" id="talk-heading"> Let's Have a Talk</h1>
                </div>

            </div>

            <div className="row justify-content-center" id="links">
                <div className="col-12">
                    <a href="mailto:rishav3330@gmail.com"><h6 className="text-center text-size">---💌Email Me--</h6></a>
                    <a href="https://www.instagram.com/bankai_rishu_no_baka/"><h6 className="text-center text-size">---🖼️DM on Insta--</h6></a>
                    <a href="tel:+91 9708058822"><h6 className="text-center text-size">---📞 Call me now--</h6></a>
                    <a href="https://www.linkedin.com/in/rishav33/"><h6 className="text-center text-size">---💼 Let's connect on LinkedIn--</h6></a>
                    <a href="https://github.com/rishav-raj-33"><h6 className="text-center text-size">---🐙 Explore my projects on GitHub--</h6></a>






                </div>
            </div>




        </div >)
        }
        </>

    )
}



export default Touch;