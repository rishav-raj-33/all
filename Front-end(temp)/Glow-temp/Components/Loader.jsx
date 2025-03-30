import { useState } from "react";

function Loader() {





    return <div id="spinner-parent">

        <div className="text-center" id="Spinner">
            <div className="spinner-border" role="status">
                <span className="visually-hidden">Loading...</span>
            </div>
        </div>

    </div>
}



export default Loader