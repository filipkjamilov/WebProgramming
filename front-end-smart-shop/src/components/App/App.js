import './App.css';
import React from 'react';
import {BrowserRouter, Route} from "react-router-dom";
import Home from "../Home/Home";
import Products from "../Products/Products";
import ProductDetails from "../Products/ProductDetails";
import Footer from "../Footer/Footer";
import ProductEdit from "../Products/ProductEdit";
import ProductAdd from "../Products/ProductAdd";
import ManufacturerAdd from "../Manufacturer/ManufacturerAdd";
import CategoryAdd from "../Category/CategoryAdd";
import ApiService from "../../repository/axiosCall";


class App extends React.Component {

    deleteIngredients = (id) => {
        console.log(id);

        ApiService.deleteProduct(id);

    }

    render() {

        const routing = (

            <BrowserRouter>
                <Route path={"/"} exact render={()=>
                        <Home />}>
                    </Route>
                    <Route path={"/products"}  exact render={()=>
                        <Products delete={this.deleteIngredients}/>}>
                    </Route>
                    <Route path={"/products/details"} component={ProductDetails}>
                    </Route>
                    <Route path={"/products/edit"} component={ProductEdit}>
                    </Route>
                    <Route path={"/products/add"} component={ProductAdd}>
                    </Route>
                    <Route path={"/products/addnewmanufacturer"} component={ManufacturerAdd}>
                    </Route>
                    <Route path={"/products/addnewcategory"} component={CategoryAdd}>
                    </Route>



                <Footer/>

            </BrowserRouter>


        )


        return (
            <div>
            {routing}
            </div>
        );

    }
}
export default App;
