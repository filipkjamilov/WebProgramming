import React from 'react';
import CenterCarousel from "../Shared/CenterCarousel";
import Product from "../Products/Product";
import MyAppBar from "../Nav/MyAppBar";
import Nav from "../Nav/Nav";
import CenterText from "../Shared/CenterText";


class Home extends React.Component{

    render(){

        return(
            <div>
                <MyAppBar/>
                <div className="container" style={{"backgroundColor":"rgb(255,255,255,0.1)", "padding":"0"}}>
                    <Nav/>

                </div>
                <CenterCarousel/>
                <CenterText/>

                <div className="container" style={{"backgroundColor":"rgb(255,255,255,0.1)", "padding":"0"}}>

                <Product pag={false}/>
                </div>
            </div>
        )
    }
}
export default Home