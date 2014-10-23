
<input type="text" name="username" value="${fieldValue(bean:signupFormModel,field:'username')}"/>
<g:hasErrors bean="${signupFormModel}" field="username">
    <div class="errors">
        <g:renderErrors bean="${signupFormModel}" field="username" as="list" />
    </div>
</g:hasErrors>