import React from "react";
import ApiService from "../../repository/axiosCall";
import Card from "@material-ui/core/Card/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions/CardActions";
import Grid from "@material-ui/core/Grid";
import {makeStyles} from "@material-ui/core/styles";
import "./Product.css";
import Nav from "../Nav/Nav";
import {Link} from "react-router-dom";
import Stripe from "../Stripe/Stripe";

class ProductDetails extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoaded: false,
            id:0

        };
    }

    loadProduct(id){
        if(!this.state.isLoaded) {
            ApiService.fetchProductById(id).then((data) => {
                console.log(data.data.name);
                this.setState({
                    isLoaded:true,
                    items:data.data
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
    };
    addToCard (){
        console.log("Adding to card");
    };


    render(){
        const useStyles = makeStyles((theme) => ({
            icon: {
                marginRight: theme.spacing(2),
            },
            heroContent: {
                backgroundColor: theme.palette.background.paper,
                padding: theme.spacing(8, 0, 6),
            },
            heroButtons: {
                marginTop: theme.spacing(4),
            },
            cardGrid: {
                paddingTop: theme.spacing(8),
                paddingBottom: theme.spacing(8),
            },
            card: {
                height: '100%',
                display: 'flex',
                flexDirection: 'column',
            },
            cardMedia: {
                paddingTop: '56.25%', // 16:9
            },
            cardContent: {
                flexGrow: 1,
            },
            footer: {
                backgroundColor: theme.palette.background.paper,
                padding: theme.spacing(6),
            },
            media: {
                height:280+"px",
                width:100+"%",
                margin:"auto",
            }
        }));
        return(
            <div>
                <div className="container" style={{"padding":"0"}}>
                    <Nav/>
                </div>
                {/*<CenterCarousel/>*/}
                <div className="container containerMargin" style={{"backgroundColor":"rgb(255,255,255,0.1)", "padding":"0"}}>
                    <Grid item xs={11} sm={9} md={9} style={{"margin":"auto"}}>
                        <Card className={useStyles.card} style={{"marginBottom":"20px", "marginTop":"20px", "display":"inline-table"}}>
                            <div style={{
                                "height": "470px",      /* equals max image height */
                                "maxWidth": "100%",
                                "whiteSpace": "nowrap",
                                "textAlign": "center",
                                "margin": "1em 0",}}>
                                            <span style={{
                                                "display": "inline-block",
                                                "height": "100%",
                                                "verticalAlign": "middle",
                                            }}></span>
                                <img src={this.state.items?.link} style={{
                                    "verticalAlign": "middle",
                                    "maxHeight": "450px",
                                    "maxWidth": "650px",}}
                                     alt={"This should be image for "+this.state.items?.name}
                                />
                            </div>

                            <CardContent className={useStyles.cardContent}>
                                <Typography gutterBottom variant="h3" component="h2" style={{"textAlign":"center"}}>
                                    {this.state.items?.name}
                                </Typography>

                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Description
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Model: {this.state.items?.name}</li>
                                        <li className="list-group-item">Manufacturer:  {this.state.items.manufacturer?.name}</li>
                                        <li className="list-group-item">Manufacturer country:  {this.state.items.manufacturer?.country}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Network
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Technology: {this.state.items?.technology}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Body
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Dimensions: {this.state.items?.dimensions}</li>
                                        <li className="list-group-item">Weight:  {this.state.items?.weight}</li>
                                        <li className="list-group-item">Build:  {this.state.items?.build}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Platform
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">OS: {this.state.items?.os}</li>
                                        <li className="list-group-item">Chipset:  {this.state.items?.chipset}</li>
                                        <li className="list-group-item">CPU:  {this.state.items?.cpu}</li>
                                        <li className="list-group-item">GPU:  {this.state.items?.gpu}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Camera
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Main Camera: {this.state.items?.mainCamera}</li>
                                        <li className="list-group-item">Selfie Camera:  {this.state.items?.selfieCamera}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Comms
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">WLAN: {this.state.items?.wlan}</li>
                                        <li className="list-group-item">Bluetooth:  {this.state.items?.bluetooth}</li>
                                        <li className="list-group-item">GPS:  {this.state.items?.gps ? "Yes" : "No"}</li>
                                        <li className="list-group-item">NFC:  {this.state.items?.nfc ? "Yes" : "No"}</li>
                                        <li className="list-group-item">Radio:  {this.state.items?.radio ? "Yes" : "No"}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Features
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Sensors: {this.state.items?.sensors}</li>
                                    </ul>
                                </div>
                                <div className={"card marginCard"} style={{"width":"100%"}}>
                                    <Typography gutterBottom variant="h6" component="h2" style={{"textAlign":"center"}}>
                                        Battery
                                    </Typography>
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Battery Type: {this.state.items?.batteryType}</li>
                                        <li className="list-group-item">Battery Life: {this.state.items?.batteryLife}</li>
                                    </ul>
                                </div>

                                <div className="input-group mb-3 marginCard">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="basic-addon1">Amazon price:</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Price" value={this.state.items?.price} readOnly/>
                                    <span className="input-group-text" id="basic-addon1">$</span>
                                </div>
                                <div style={{"width":"100%"}}>
                                    <Stripe price={this.state.items?.price}/>
                                </div>
                            </CardContent>
                            <CardActions>
                                <Link className="btn btn-dark btn-sm" to={"/products/edit?id="+this.state.items?.id}>Edit this {this.state.items.category?.name}</Link>
                                <button className="btn btn-danger btn-sm" size="small" color="primary"
                                        onClick={() => { this.addToCard() }} id={this.state.items?.id}>Delete</button>
                            </CardActions>

                        </Card>
                    </Grid>

                </div>
            </div>

        )
    }


}
export default ProductDetails;