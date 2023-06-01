require("dotenv").config();

const cors = require("cors");
const express = require("express");
const authRoutes = require("./routes/authRoute");
const medicineRouter = require("./routes/medicineRouter");
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors({ origin: "*" }));

app.use("/api/v1/auth", authRoutes);
app.use("/api/v1/medicine", medicineRouter);

app.get("/", function (req, res) {
  res.send(`Hello World ${process.env.JWT_SECRET}`);
});

app.get("/greeting/:name", (req, res) => {
  const name = req.params.name;
  res.send(`Hello, ${name}!`);
});

console.log(process.env.JWT_SECRET);

const server = app.listen(8080, function () {
  const port = server.address().port;

  console.log("Example app listening at http://localhost:%s", port);
});
