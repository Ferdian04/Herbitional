const express = require("express");
const router = express.Router();
const userController = require("../controllers/userController");
const jwtAuth = require("../middleware/jwtAuth");
const { route } = require("./authRouter");

router.use((req, res, next) => {
  console.log("Time: ", Date.now());
  next();
});

router.get("/profile/:id", jwtAuth(), userController.profile);
router.post("/inshistori", jwtAuth(), userController.inshistori);
module.exports = router;
