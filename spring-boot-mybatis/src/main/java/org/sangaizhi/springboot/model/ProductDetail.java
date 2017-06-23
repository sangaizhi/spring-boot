package org.sangaizhi.springboot.model;

/**
 * @author sangaizhi
 * @date 2017/6/22
 */
public class ProductDetail {

    private Long id;

    private Long productId;

    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
