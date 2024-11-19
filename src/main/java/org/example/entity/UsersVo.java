package org.example.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UsersVo {
    /** 版本号 */
    private static final long serialVersionUID = -61540348507379010L;
    private String token;
    private Long id;
    private String name;
    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsersVo(Long id, String name,String token) {
        this.token = token;
        this.id = id;
        this.name = name;
    }
}