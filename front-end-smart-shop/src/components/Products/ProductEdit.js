import React from "react";
import ApiService from "../../repository/axiosCall";
import "./Product.css";
import Nav from "../Nav/Nav";
import {Link} from "react-router-dom";
class ProductEdit extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            products: null,
            areProductsLoaded: false,
            categories:null,
            manufacturers:null,
            announced:'',
            cat:'',
            id:0,
            name:'',
            man:'',
            link:'',
            technology:'',
            dimensions:'',
            weight:'',
            build:'',
            os:'',
            chipset:'',
            cpu:'',
            gpu:'',
            mainCamera:'',
            selfieCamera:'',
            wlan:'',
            bluetooth:'',
            gps:'',
            nfc:'',
            radio:'',
            sensors:'',
            batteryType:'',
            batteryLife:'',
            price:'',
            description:'',
            submit:false
        };
    }


    onChange = (e) => {
           this.setState({ [e.target.name]: e.target.value });
    };

    onSubmit = (e) => {
        e.preventDefault();
        // get our form data out of state
        const check = document.getElementById("check");
        if(check.checked){
            const {description, name, announced,man, link, technology, dimensions, weight, build, os, chipset, cpu, gpu, mainCamera, selfieCamera, wlan, bluetooth, gps, nfc, radio, sensors, batteryType, batteryLife, price, cat } = this.state;

            let manufacturer = {};
            let category = {};

            for(let m in this.state.manufacturers){
                if(this.state.manufacturers[m].id == man){
                    manufacturer = this.state.manufacturers[m];
                }
            }

            for(let c in this.state.categories){
                if(this.state.categories[c].id == cat){
                    category = this.state.categories[c];
                }
            }




            const obj = {name,description,technology,announced,dimensions,weight,build,os,chipset,cpu,gpu,mainCamera,selfieCamera,wlan,bluetooth,gps,nfc,radio,sensors,batteryType,batteryLife,link,price,category, manufacturer};

            ApiService.updateProduct(obj, this.state.products?.id);

            //this.setState({submit:true});
        }else{
            alert("Please agree to Terms and Conditions!");
        }
       
        

    }


    loadProduct(id){
        if(!this.state.areProductsLoaded) {
            ApiService.fetchProductById(id).then((data) => {
                const product = data.data;
                this.setState({
                    areProductsLoaded:true,
                    products:product,
                    name:product.name,
                    announced:product.announced,
                    cat:product.category.id,
                    man:product.manufacturer.id,
                    description:product.description,
                    link:product.link,
                    technology:product.technology,
                    dimensions:product.dimensions,
                    weight:product.weight,
                    build:product.build,
                    os:product.os,
                    chipset:product.chipset,
                    cpu:product.cpu,
                    gpu:product.gpu,
                    mainCamera:product.mainCamera,
                    selfieCamera:product.selfieCamera,
                    wlan:product.wlan,
                    bluetooth:product.bluetooth,
                    gps:product.gps,
                    nfc:product.nfc,
                    radio:product.radio,
                    sensors:product.sensors,
                    batteryType:product.batteryType,
                    batteryLife:product.batteryLife,
                    price:product.price
                });
            });

            ApiService.fetchAllCategories().then((data) => {
                this.setState({
                    categories:data.data
                });

            });
            ApiService.fetchAllManufacturers().then((data) => {
                this.setState({
                    manufacturers:data.data
                });

            });

        }
    };

    componentDidMount() {

        const str = this.props.location.search;

        var id = str.split("=");
        this.setState({id:id[1]}, ()=>{
            this.loadProduct(id[1]);
        });
    }


    render(){
        return(

            <div>
                <div className="container" style={{"padding":"0"}}>
                    <Nav/>
                </div>
                <div>
                <form className={"container bg-light"} onSubmit={this.onSubmit}>

                    <div>
                        <h1>Edit {this.state.products?.name}</h1>
                    </div>

                    <div className="form-row">
                        <div className="form-group col-md-6">
                            <label htmlFor="cat">Category</label>
                            <select onChange={this.onChange} name="cat" className="form-control">
                                {this.state.categories?.map((ca) => (
                                    <option key={ca?.id} selected={ca?.name === this.state.products?.category?.name ? true : false} value={ca?.id} >{ca?.name}</option>
                                ))}
                            </select>
                            <small className="form-text text-muted">If you don't see the category you need here please add it
                                <Link className="" to={"/products/addnewcategory"}> here.</Link>
                            </small>
                        </div>
                        <div className="form-group col-md-6">
                            <label htmlFor="description">Description</label>
                            <input onChange={this.onChange} name="description" type="text" defaultValue={this.state.products?.description} className="form-control" placeholder="Description"/>
                        </div>
                    </div>

                    <div className="form-row">
                        <div className="form-group col-md-4">
                            <label htmlFor="name">Model</label>
                            <input name="name" onChange={this.onChange} defaultValue={this.state.products?.name} type="text" className="form-control" placeholder="Enter model"/>
                            <small className="form-text text-muted">Try to put the man as first word. ex.(man Model)[Samsung Galaxy S20]</small>
                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="announced">Announced</label>
                            <input onChange={this.onChange} name="announced" type="text" defaultValue={this.state.products?.announced} className="form-control" placeholder="Announced"/>
                            <small className="form-text text-muted">Format as "Year, Month Day" ex.[2020, February 11]</small>
                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="man">Manufacturer</label>
                            <select onChange={this.onChange} name="man" className="form-control">
                                {this.state.manufacturers?.map((ma) => (
                                    <option selected={ma?.name === this.state.products?.manufacturer?.name ? true : false} key={ma?.name} value={ma?.id  }>{ma?.name}</option>
                                ))}
                            </select>
                            <small className="form-text text-muted">If you don't see the manufacturer you need here please add it
                                <Link className="" to={"/products/addnewmanufacturer"}> here.</Link>
                            </small>
                        </div>
                        </div>
                    <div className="form-group">
                        <label htmlFor="link">Image URL</label>
                        <input onChange={this.onChange} name="link" type="text" defaultValue={this.state.products?.link} className="form-control" placeholder="Image URL"/>
                    </div>
                    <div className="form-row">
                        <div className="form-group col-md-4">
                            <label htmlFor="technology">Technology</label>
                            <input onChange={this.onChange} name="technology" type="text" defaultValue={this.state.products?.technology} className="form-control" placeholder="Technology"/>
                            <small className="form-text text-muted">Technology ex.[GSM / HSPA / LTE / 5G]</small>
                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="dimensions">Dimensions</label>
                            <input onChange={this.onChange} name="dimensions" type="text" defaultValue={this.state.products?.dimensions} className="form-control" placeholder="Dimensions"/>
                            <small className="form-text text-muted">Dimensions as ex.[159.2 x 75.1 x 8.9 mm (6.27 x 2.96 x 0.35 in)]</small>
                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="weight">Weight</label>
                            <input onChange={this.onChange} name="weight" type="text" defaultValue={this.state.products?.weight} className="form-control" placeholder="Weight"/>
                            <small className="form-text text-muted">Weight ex.[191 g (6.74 oz)]</small>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="build">Build</label>
                        <input onChange={this.onChange} name="build" type="text" defaultValue={this.state.products?.build} className="form-control" placeholder="Build"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="os">OS</label>
                        <input onChange={this.onChange} name="os" type="text" defaultValue={this.state.products?.os}  className="form-control" placeholder="OS"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="chipset">Chipset</label>
                        <input onChange={this.onChange} name="chipset" type="text" defaultValue={this.state.products?.chipset} className="form-control" placeholder="man"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="cpu">CPU</label>
                        <input onChange={this.onChange} name="cpu" type="text" defaultValue={this.state.products?.cpu} className="form-control" placeholder="CPU"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="gpu">GPU</label>
                        <input onChange={this.onChange} name="gpu" type="text" defaultValue={this.state.products?.gpu} className="form-control" placeholder="GPU"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="mainCamera">Main Camera</label>
                        <input onChange={this.onChange} name="mainCamera" type="text" defaultValue={this.state.products?.mainCamera} className="form-control" placeholder="Main Camera"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="selfieCamera">Selfie Camera</label>
                        <input onChange={this.onChange} name="selfieCamera" type="text" defaultValue={this.state.products?.selfieCamera} className="form-control" placeholder="Selfie Camera"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="wlan">WLAN</label>
                        <input onChange={this.onChange} name="wlan" type="text" defaultValue={this.state.products?.wlan} className="form-control" placeholder="WLAN"/>
                    </div>
                    <div className="form-row">
                        <div className="form-group col-md-3">
                            <label htmlFor="bluetooth">Bluetooth</label>
                            <input onChange={this.onChange} name="bluetooth" type="text" className="form-control" placeholder="Bluetooth"/>
                        </div>
                        <div className="form-group col-md-3">
                            <label htmlFor="gps">GPS</label>
                            <select onChange={this.onChange} name="gps" className="form-control">
                                <option selected={!this.state.products?.gps ? true:false} value={true}>Yes</option>
                                <option selected={!this.state.products?.gps ? true:false} value={false}>No</option>
                            </select>
                        </div>
                        <div className="form-group col-md-3">
                            <label htmlFor="nfc">NFC</label>
                            <select onChange={this.onChange} name="nfc" className="form-control">
                                <option selected={!this.state.products?.nfc ? true:false} value={true}>Yes</option>
                                <option selected={!this.state.products?.nfc ? true:false} value={false}>No</option>
                            </select>
                        </div>
                        <div className="form-group col-md-3">
                            <label htmlFor="radio">Radio</label>
                            <select onChange={this.onChange} name="radio" className="form-control" defaultValue={this.state.products?.radio}>
                                <option selected={!this.state.products?.radio ? true:false} value={true}>Yes</option>
                                <option selected={!this.state.products?.radio ? true:false} value={false}>No</option>
                            </select>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="sensors">Sensors</label>
                        <input onChange={this.onChange} name="sensors" type="text" defaultValue={this.state.products?.sensors} className="form-control" placeholder="Sensors"/>
                    </div>
                    <div className="form-row">
                        <div className="form-group col-md-6">
                            <label htmlFor="batteryType">Battery Type</label>
                            <input onChange={this.onChange} name="batteryType" type="text" defaultValue={this.state.products?.batteryType} className="form-control" placeholder="Battery Type"/>
                        </div>
                        <div className="form-group col-md-6">
                            <label htmlFor="batteryLife">Battery Life</label>
                            <input onChange={this.onChange} name="batteryLife" type="text" defaultValue={this.state.products?.batteryLife} className="form-control" placeholder="Battery Life"/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Amazon price</label>
                        <input onChange={this.onChange} name="price" type="number" defaultValue={this.state.products?.price} className="form-control" placeholder="Amazon price"/>
                    </div>

                    <div className="form-check">
                        <input type="checkbox" className="form-check-input" id="check"/>
                        <label className="form-check-label" htmlFor="exampleCheck1">I agree to the <a href="#">Terms and conditions</a> for editing this product.</label>
                    </div>
                    <button type="submit" className="btn btn-primary" style={{"width":"100%", "marginBottom":"10px"}}>Submit</button>
                </form>
                </div>
            </div>

        )
    }


}
export default ProductEdit;