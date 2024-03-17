@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
    @if(page.getName() != null)
        ${String.valueOf(page.getName())}
    <form action="${NamedRoutes.logoutPath()}" method="post">
        <input type="submit" value="Выйти" />
    </form>
    @endif
`
)