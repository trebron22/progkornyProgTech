
$("#form").validate({
    rules: {
      username: "required",
      password: "required"
    },
    messages: {
      username: ruleUsername,
      password: rulePassword
    }
  });