package br.com.projetoweb.projetoweb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_UserProfile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idUserProfile", nullable = false)
    private long idUserProfile;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios;

    public long getIdUserProfile() { return idUserProfile; }
    public void setIdUserProfile(long idUserProfile) { this.idUserProfile = idUserProfile; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Set<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<Usuario> usuarios) { this.usuarios = usuarios; }
}
