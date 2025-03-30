import BuildSkeleton from "./Skeleton/BuildSkeleton";
import { useState } from 'react';
import { useEffect } from 'react';

function Build() {



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

    isDelay?(<BuildSkeleton/>): (  <div className="container-fluid" id="build-with">

                    <div className="row justify-content-center">
                        <div className="col-12">
                            <h1 className="text-center" id="build-with-title">Build With</h1>
                            <p className="text-center" id="title-sub-text">Technologies and tools that power the Glow Application</p>
                        </div>
                    </div>

                    <div className="row justify-content-evenly" id="objective-section">
                        <div className="col-md-5 mt-3">
                            <h1 id="pbjective-title">*The Idea Behind Glow</h1>
                            <h5 className="color">objective:</h5>
                            <p id="objective-content" className="text-right">The Glow application was born out of a personal challenge to explore the feasibility and potential of building a cohesive, multi-faceted application using a variety of programming languages. My primary goal was to combine the strengths of different languages to address distinct aspects of the project, ultimately creating a seamless, unified solution.

                                Glow leverages Python for advanced image processing tasks, particularly through the use of the powerful OpenCV library. Python's extensive ecosystem, ease of use, and flexibility make it an ideal choice for image manipulation, filtering, and visual effects, which are at the core of this application. Through Glow, users can apply a range of dynamic and customizable filters to images, enhancing their visual appeal and enabling new creative possibilities.</p>
                        </div>
                        <div className="col-md-5 mt-3">
                            <h1 className="color" id="challange">*Primary Challange</h1>
                            <h5 id="question">How to run Different Programming Language by One Language?</h5>
                            <p id="answer">When I first started working on my Spring Boot project, I encountered a challenge: I needed to run various external programming scripts—such as Python, and C++—from within the application. Initially, I was unsure how to execute these scripts efficiently from Java without directly integrating the scripts into the codebase. I realized this was a common requirement for projects involving external processes, so I began researching a solution.

                                As I explored different options, I came across the ProcessBuilder class, which seemed to be the perfect fit for this task. ProcessBuilder allows Java to execute system processes like running shell commands or external scripts as separate processes. This made it possible for me to integrate and control the execution of different programming languages like Python, Bash, and C++ directly from my Spring Boot application.</p>
                        </div>
                    </div>
                    <div className="row justify-content-center">
                        <div className="col-12">
                            <h1 className="color text-center" id="tech--used">Tools and Technologies Involved</h1>
                        </div>
                    </div>
                    <div className="row justify-content-evenly" id="tech-content">
                        <div className="col-md-3 mt-3" id="lan">
                            <h5 className="color">Languages and Frameworks</h5>
                            <p className="text-center color"><b>Java: </b>
                                Java in the Glow project is used for managing backend services, handling system processes, and orchestrating the integration of Python and C++ components to create a seamless image processing and metadata extraction workflow</p>
                            <p className="text-center color"><b>Python: </b>
                                Python is used for advanced image processing and applying dynamic filters to images, leveraging libraries like OpenCV to enhance visual effects and manipulation.</p>
                            <p className="text-center color"><b>C++: </b>
                                C++ is used solely for file handling of image metadata, ensuring efficient reading, writing, and manipulation of metadata files.</p>
                            <p className="text-center color"><b>HTML: </b>
                                HTML is used to structure and present the user interface, allowing users to interact with the application and view processed images and metadata in a visually organized manner.</p>
                            <p className="text-center color"><b>CSS: </b>
                                CSS is used to style the user interface, enhancing the visual presentation of processed images, metadata, and interactive elements for an engaging user experience.</p>
                            <p className="text-center color"><b>JavaScript: </b>
                                JavaScript is used to add interactivity to the user interface, enabling dynamic features like real-time updates and user-driven image processing actions.</p>
                            <p className="text-center color"><b>Bootstrap: </b>
                                Bootstrap is used to design a responsive and visually appealing user interface, ensuring consistent layout and styling across different devices.</p>
                            <p className="text-center color"><b>SQL: </b>
                                SQL is used to interact with the MySQL database, performing operations like querying, inserting, and updating image metadata efficiently</p>
                            <p className="text-center color"><b>Spring: </b>
                                Spring is used to automate object creation through annotations, enabling efficient dependency injection and streamlining the management of application components.</p>
                            <p className="text-center color"><b>Spring Boot: </b>
                                Spring Boot is used to simplify the development of the backend, providing a fast and efficient way to set up and configure the application with minimal configuration.</p>
                            <p className="text-center color"><b>React Js: </b>
                                React JS is used for building a dynamic and interactive user interface, enabling real-time updates and smooth user experiences when processing and displaying images.</p>


                        </div>

                        <div className="col-md-3 mt-3" id="con">
                            <h5 className="color">Concepts</h5>
                            <p className="text-center color"><b>Java Regex: </b>
                                Java Regex is used to clean and sanitize image metadata by identifying and removing unnecessary or malformed data, ensuring the extracted information is structured and consistent.</p>
                            <p className="text-center color"><b>Multi-Threading: </b>
                                multithreading is utilized to optimize performance by creating two threads: one for generating a text file of image metadata and another for running Python-based image filters, enabling faster parallel processing.</p>
                            <p className="text-center color"><b>Command-line-argument: </b>
                                command line arguments are used to pass metadata and filter type from the Spring Boot application, enabling dynamic execution of image processing tasks and metadata extraction through Python and C++ components.</p>
                            <p className="text-center color"><b>OOPS Concepts: </b>
                                OOP (Object-Oriented Programming) principles are applied to organize and structure the code, enhancing maintainability and scalability, especially in managing image processing and metadata handling components.</p>
                            <p className="text-center color"><b>Exception Handling: </b>
                                exception handling is implemented to manage errors during metadata processing and filter application, ensuring the application remains robust and handles unexpected issues gracefully.</p>
                            <p className="text-center color"><b>Collection Framework: </b>
                                Java Collection Framework is used to convert entity classes to DTO classes, streamlining data transformation and transfer between layers.</p>
                            <p className="text-center color"><b>Media Query: </b>
                                Media queries are used to customize Bootstrap's default styles, allowing for a more tailored and responsive design that adapts to various screen sizes.</p>
                            <p className="text-center color"><b>Base64 Encoding: </b>
                                Base64 encoding is used to send multiple files simultaneously to the frontend, converting the files into a text format for efficient transmission.</p>
                            <p className="text-center color"><b>REST API: </b>
                                REST API is used to facilitate communication between the frontend and backend, allowing for seamless data exchange, such as sending image files and retrieving processed results.</p>
                            <p className="text-center color"><b>Three Tier Architecture: </b>
                                three-tier architecture is implemented, separating the application into distinct layers: presentation, business logic, and data, ensuring modularity, scalability, and maintainability.</p>
                        </div>

                        <div className="col-md-3 mt-3" id="tool">
                            <h5 className="color">Tools and Libraries</h5>
                            <p className="text-center color"><b>STS IDE: </b>
                                STS IDE (Spring Tool Suite) is used for developing and managing the backend services, enabling seamless integration of various components</p>
                            <p className="text-center color"><b>PyCharm IDE: </b>
                                PyCharm IDE is used for developing and debugging the Python-based image processing components, providing a streamlined environment for implementing filters.</p>
                            <p className="text-center color"><b>Visual Studio Code IDE: </b>
                                Visual Studio Code is used for writing and editing C++ code, providing a streamlined and efficient environment for implementing the file handling of image metadata.</p>
                            <p className="text-center color"><b>IntelliJ Idea Community Edition: </b>
                                IntelliJ Community Edition is used for testing and validating Java code flow before integrating it into the application, ensuring smooth functionality and reliability.</p>
                            <p className="text-center color"><b>Maven: </b>
                                Maven is used for managing project dependencies, building the application, and ensuring smooth integration of Java-based backend services.</p>
                            <p className="text-center color"><b>Tomacat: </b>
                                Apache Tomcat is used as the application server to deploy and run the Spring Boot application, facilitating seamless backend operations and communication.</p>
                            <p className="text-center color"><b>Postman: </b>
                                Postman is used for testing and validating the RESTful API endpoints, ensuring proper communication between the frontend and backend services.</p>
                            <p className="text-center color"><b>MySQL: </b>
                                MySQL is used to store the filter details that the application currently supports, allowing efficient management and retrieval of filter configurations.</p>
                            <p className="text-center color"><b>Git and GitHub: </b>
                                Git is used for version control to track code changes, while GitHub is used for hosting the repository, collaborating with team members, and managing code revisions.</p>
                            <p className="text-center color"><b>Base64 Encoder: </b>
                                Base64 encoder is used to encode multiple image files into text format and Jpeg Format.</p>
                            <p className="text-center color"><b>SLF4j: </b>
                                SLF4J is used for logging, providing a simple and consistent logging framework that integrates with various logging libraries for efficient tracking and debugging of the application's operations.</p>
                            <p className="text-center color"><b>Mokito: </b>
                                Mockito is used for unit testing, enabling the creation of mock objects to simulate interactions with external dependencies and ensuring the robustness of backend services.</p>
                            <p className="text-center color"><b>Open Cv: </b>
                                OpenCV is used with Python to apply filters to images, enhancing their appearance and performing image transformations efficiently.</p>
                            <p className="text-center color"><b>fStream: </b>
                                fstream is used for handling text files, specifically for reading and writing image metadata to .txt files in C++.</p>
                            <p className="text-center color"><b>numpy: </b>
                                NumPy is used in Python to create a blank image as the base for applying filters to images, providing a foundation for further image manipulation.</p>
                            <p className="text-center color"><b>meta data extractor: </b>
                                metadata-extractor is used for extracting and parsing image metadata, enabling efficient retrieval of details such as camera settings, date, and resolution from image files.</p>



                        </div>


                    </div>


                </div> )

}
        
            

            

        </>
    )
}


export default Build