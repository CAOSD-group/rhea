let express = require("express");

let app = express();

app.get("/test", (req,resp) => {
	resp.sendFile("/var/www/html/index.html");
});
app.use(express.static("ecosystem-toolkit-for-variability-models/"));
app.use("/rheaweb",express.static("rhea-web/"));

app.listen(80, () => {
	console.log("Running");
});
