<g:if test="${currentPost}">
    <div id="vote" name="vote">
        <g:formRemote name="voteUpForm" url="[controller:'vote', action:'addVote']" method="GET" update="resultAddingVote${currentPost.id}">
            <g:hiddenField name="up" value="1"/>
            <g:hiddenField name="postId" value="${currentPost.id}"/>
            <g:hiddenField name="authorId" value="1"/>
            <g:actionSubmitImage value="http://www.designofsignage.com/application/symbol/building/image/600x600/arrow-up-circle.jpg" width="30" height="30" alt="+" />
        </g:formRemote>
        <div id="resultAddingVote${currentPost.id}">
            <span id="voteResult">${currentPost.getCountingVote()}</span>
        </div>
        <g:formRemote name="voteDownForm" url="[controller:'vote', action:'addVote']" method="GET" update="resultAddingVote${currentPost.id}">
            <g:hiddenField name="up" value="0"/>
            <g:hiddenField name="postId" value="${currentPost.id}"/>
            <g:hiddenField name="authorId" value="1"/>
            <g:actionSubmitImage value="http://www.designofsignage.com/application/symbol/building/image/600x600/arrow-down-circle.jpg" width="30" height="30" alt="-" />
        </g:formRemote>
    </div>

    <div id="displayPost" style="border: 1px #000000 solid">
        <div class="property-value" name="content"><g:fieldValue bean="${currentPost}" field="content"/></div>
        <span class="property-value" name="creationDate"><g:fieldValue bean="${currentPost}" field="creationDate"/></span> |
        <span class="property-value" name="lastEditionDate"><g:fieldValue bean="${currentPost}" field="lastEditionDate"/></span><br />

        <g:set var="currentUser" value="${currentPost.author}" />
        <g:render template="../user/showUser" />
    </div>
</g:if>