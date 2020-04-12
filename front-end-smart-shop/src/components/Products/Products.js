import React from 'react';
import Product from "../Products/Product";
import Nav from "../Nav/Nav";
import CenterPictureAd from "../Shared/CenterPictureAd";


class Products extends React.Component{

    render(){

        return(
                <div>
                    <div className="container" style={{"padding":"0"}}>
                        <Nav/>
                    </div>

                    <div className="container" style={{"background-color":"rgb(255,255,255,0.1)", "padding":"0", "marginTop":"15px"}}>
                        <CenterPictureAd/>
                        <Product delete={this.props.delete} pag={true}/>
                    </div>
                </div>
        )
    }
}
export default Products