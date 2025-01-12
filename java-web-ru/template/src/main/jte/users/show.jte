@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <meta charset="utf-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</title>
</head>
<main>
    <h1>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</h1>
    <p>${page.getUser().getEmail()}</p>
</main>
</html>