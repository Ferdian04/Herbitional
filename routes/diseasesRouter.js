const express = require("express");
const router = express.Router();
const diseasesController = require("../controllers/diseasesController");
const jwtAuth = require("../middleware/jwtAuth");

router.use((req, res, next) => {
  console.log("Time: ", Date.now());
  next();
});

router.get("/specificdis/:id_penyakit", jwtAuth(), diseasesController.specificdis);

module.exports = router;
