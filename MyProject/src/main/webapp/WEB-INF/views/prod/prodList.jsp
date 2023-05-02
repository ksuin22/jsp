<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 반복문 쓰기위해서 taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="prod" items="${prodList }">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<c:choose>
						<c:when test="${prod.salePrice == 1}">
						</c:when>
						<c:otherwise>
						<div class="badge bg-danger text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						</c:otherwise>
						</c:choose>
						<!-- Product image-->
						<img class="card-img-top" src="images/${prod.image }" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								${prod.prodNo }
								<!-- Product name-->
								<!-- forEach에 var=prod라서 prod.prodNo-->
								<h5 class="fw-bolder">${prod.prodName }</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<div id="price">
								<c:choose>
									<c:when test="${prod.salePrice == 1}">
									   ${prod.price }원
								     </c:when>
									<c:otherwise>
										<span class="text-muted text-decoration-line-through">${prod.price }원</span>
										${prod.price * prod.salePrice }원
								    </c:otherwise>
								</c:choose>
								</div>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="prodMain.do?no=${prod.prodNo }">상품보기</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</section>
<script>

</script>