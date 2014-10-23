
<input type="text" name="username" value="${fieldValue(bean:signupFormModel,field:'username')}"/>
<g:hasErrors bean="${signupFormModel}" field="username">
    <div class="errors">
        <g:renderErrors bean="${signupFormModel}" field="username" as="list" />
    </div>
</g:hasErrors>
<br>
<input type="password" name="password" value="${fieldValue(bean:signupFormModel,field:'password')}"/>
<g:hasErrors bean="${signupFormModel}" field="password">
    <div class="errors">
        <g:renderErrors bean="${signupFormModel}" field="password" as="list" />
    </div>
</g:hasErrors>
<br>
<input type="password" name="repeatPassword" value="${fieldValue(bean:signupFormModel,field:'repeatPassword')}"/>
<g:hasErrors bean="${signupFormModel}" field="repeatPassword">
    <div class="errors">
        <g:renderErrors bean="${signupFormModel}" field="repeatPassword" as="list" />
    </div>
</g:hasErrors>