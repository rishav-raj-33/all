import canny from '/src/assets/canny.jpg';

function B_Slogan() {


    return (

        <div className="container-fluid" id="slogan">

            <h1 className="text-center" id="slogan-h1">Exploring the intersection of</h1> <h1 className="text-center" id="tech">Technologies </h1>
            <h5 className="text-center" id="slogan-h5">Push the limits of innovation by combining popular technologies </h5>
           
           <div className="row justify-content-evenly" id="filter-description-div">
            <div className="col-6">
                <img width={600} className='image-fluid' src={canny}></img>
            </div>
                <div className="col-6" id="photo-content">
                    

                </div>

           </div>

 

        </div>



    )







}



export default B_Slogan;