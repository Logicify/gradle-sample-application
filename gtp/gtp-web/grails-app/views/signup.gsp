<g:applyLayout name="singleColumn">
    <content tag="main">
        <h1 class="cover-heading">Signup</h1>
        <g:form url="[controller: 'auth', action: 'signup']">
            <frm:signupForm model="${signupFormModel}"/>
            <g:submitButton name="submit">Signup</g:submitButton>
        </g:form>
    </content>
</g:applyLayout>