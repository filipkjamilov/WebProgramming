import React from 'react';
import Typography from "@material-ui/core/Typography";

const MyAppBar = () => {
    return (

        <div style={{"width":"100%", "height":"30px", "backgroundColor":"rgb(0,157,218)"}}>
            <Typography variant="h6" color="inherit" noWrap style={{textAlign:"center"}}>
                3 Tips from the World Health Organization:
                Wash your hands frequently.
                Avoid touching your face.
                Sneeze and cough into a tissue or your elbow.
            </Typography>
        </div>


    )
}
export default MyAppBar;