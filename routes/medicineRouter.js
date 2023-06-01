const express = require("express");
const router = express.Router();
const medicineController = require("../controllers/medicineController");
const jwtAuth = require("../middleware/jwtAuth");

router.get("/getmed", medicineController.getMed);
router.get("/specificmed/:id_artikel", medicineController.specificmed);
router.get("/home", medicineController.home);

module.exports = router;
