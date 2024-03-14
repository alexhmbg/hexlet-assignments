@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    @for(var post : page.getPosts())
        <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
    @endfor
    @if(page.getPageNum() > 1)
    <a href="${NamedRoutes.postsPath()}?page=${page.getPageNum() - 1}">Backward</a>
    @endif
    <a href="${NamedRoutes.postsPath()}?page=${page.getPageNum() + 1}">Forward</a>
`
)