const express = require("express");
const router = express.Router();
const userController = require("../controllers/userController");
const jwtAuth = require("../middleware/jwtAuth");

router.use((req, res, next) => {
  console.log("Time: ", Date.now());
  next();
});

router.get("/profile/:id", jwtAuth(), userController.profile);

module.exports = router;
