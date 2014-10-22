<ul class="nav masthead-nav">
    <li><g:link mapping="home">Home</g:link></li>
    <li><g:link mapping="twoColExamplePage">Example 2 cols page</g:link></li>
    <li><g:link mapping="devPage">Dev Page</g:link></li>
    <sec:ifLoggedIn>
        <li>Hi, <sec:username/></li>
        <li><g:link controller="auth" action="logout">Logout</g:link></li>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <li><g:link controller="auth" action="login">Login</g:link></li>
    </sec:ifNotLoggedIn>
</ul>