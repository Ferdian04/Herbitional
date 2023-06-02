const express = require("express");
const router = express.Router();
const medicineController = require("../controllers/medicineController");
const jwtAuth = require("../middleware/jwtAuth");

router.use((req, res, next) => {
  console.log("Time: ", Date.now());
  next();
});

router.get("/specificmed/:id_artikel", jwtAuth(), medicineController.specificmed);
router.get("/searchmed/:search", jwtAuth(), medicineController.searchmed);
router.get("/home", jwtAuth(), medicineController.home);

module.exports = router;
