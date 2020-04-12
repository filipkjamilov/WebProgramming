import '../../components/App/App.css';
import React from 'react';
import {makeStyles} from "@material-ui/core/styles";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import {Carousel} from "react-responsive-carousel";

class CenterCarousel extends React.Component {


    render() {

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
        }));



        return (
            <div className={useStyles.heroContent}>
                <Carousel showArrows={false} dynamicHeight={true} infiniteLoop={true} showThumbs={false} showStatus={false} autoPlay={true}>
                    <div>
                        <img alt="da" src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fss7.vzw.com%2Fis%2Fimage%2FVerizonWireless%2FApple_iPhone_11_Red_09102019_f%3F%24png8alpha256%24%26hei%3D400&f=1&nofb=1" />
                    </div>
                    <div>
                        <img alt="da" src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimg.pngio.com%2Fget-our-unlimited-plan-with-one-of-the-latest-smartphones-included-just-40-mo-mobile-phone-png-png-750_750.png&f=1&nofb=1" />
                    </div>
                    <div>
                        <img alt="da" src="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.pngonly.com%2Fwp-content%2Fuploads%2F2017%2F06%2FApple-iPhone-PNG-02.png&f=1&nofb=1" />
                    </div>
                </Carousel>
            </div>

        );

    }
}
export default CenterCarousel;
