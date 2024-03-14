@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div>${page.getPost().getId()}</div>
    <div>${page.getPost().getName()}</div>
    <div>${page.getPost().getBody()}</div>
`
)