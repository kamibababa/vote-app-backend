package org.example.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

@TableName("userinfo")
public class UsersEntity {
    /** 版本号 */
    private static final long serialVersionUID = -61540348507379010L;

    @JsonIgnore
    /**  */
    private Long id;
    
    /**  */
    private String name;
    /**  */
    private String password;

    public UsersEntity(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public Long getId() {
        return this.id;
    }
     
    /**
     * 设置
     * 
     * @param id
     *          
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置
     * 
     * @param username
     *          
     */
    public void setName(String username) {
        this.name = username;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getPassword() {
        return this.password;
    }
     
    /**
     * 设置
     * 
     * @param password
     *          
     */
    public void setPassword(String password) {
        this.password = password;
    }
}