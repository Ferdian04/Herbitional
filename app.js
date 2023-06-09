require("dotenv").config();

const cors = require("cors");
const express = require("express");
const authRoutes = require("./routes/authRouter");
const medicineRouter = require("./routes/medicineRouter");
const userRouter = require("./routes/userRouter");
const diseasesRouter = require("./routes/diseasesRouter");
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors({ origin: "*" }));

app.use("/api/v1/auth", authRoutes);
app.use("/api/v1/medicine", medicineRouter);
app.use("/api/v1/user", userRouter);
app.use("/api/v1/diseases", diseasesRouter);

app.get("/", function (req, res) {
  res.send(`Project kita top 15 aamiin`);
});

console.log(process.env.JWT_SECRET);

const server = app.listen(8080, function () {
  const port = server.address().port;

  console.log("Example app listening at http://localhost:%s", port);
});
