package br.com.projuris.procontrol.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.projuris.procontrol.constants.Status;

@Entity
public class Equipment {
    @Id
    @GeneratedValue
    private Long id;
    private String problem;
    private Status status;
    private String description;
    private String responsible;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Client client;

    public Equipment() {
    }

    public Equipment(
        String problem, Category category, 
        Status status, String description, 
        String responsible, Client client) {

        this.problem = problem;
        this.category = category;
        this.status = status;
        this.description = description;
        this.responsible = responsible;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((problem == null) ? 0 : problem.hashCode());
        result = prime * result + ((responsible == null) ? 0 : responsible.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipment other = (Equipment) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (problem == null) {
            if (other.problem != null)
                return false;
        } else if (!problem.equals(other.problem))
            return false;
        if (responsible == null) {
            if (other.responsible != null)
                return false;
        } else if (!responsible.equals(other.responsible))
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Equipment [category=" + category + ", client=" + client + ", description=" + description + ", id=" + id
                + ", problem=" + problem + ", responsible=" + responsible + ", status=" + status + "]";
    }
}