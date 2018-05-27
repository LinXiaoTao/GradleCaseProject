package com.example.gradle;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.api.provider.Property;

import java.util.function.Consumer;

import javax.inject.Inject;

/**
 * Created on 2018/5/22 上午9:40
 * leo linxiaotao1993@vip.qq.com
 */
public class HelloModel {

    private final Property<String> testProperty;
    private String outFile;
    private final InfoModel info;
    private final NamedDomainObjectContainer<ValueModel> other;

    public HelloModel(Project project) {
        testProperty = project.getObjects().property(String.class);
        info = project.getObjects().newInstance(InfoModel.class);
        other = project.container(ValueModel.class);
    }

    public Property<String> getTestProperty() {
        return testProperty;
    }

    public String getOutFile() {
        return outFile;
    }

    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public InfoModel getInfo() {
        return info;
    }

    public NamedDomainObjectContainer<ValueModel> getOther() {
        return other;
    }

    public void info(Action<InfoModel> action) {
        action.execute(info);
    }

    public void other(Action<NamedDomainObjectContainer<ValueModel>> action) {
        action.execute(other);
    }

    @Override
    public String toString() {

        StringBuilder otherString = new StringBuilder();
        other.forEach(new Consumer<ValueModel>() {
            @Override
            public void accept(ValueModel valueModel) {
                otherString.append(valueModel.toString())
                        .append(" ");
            }
        });

        return "HelloModel{" +
                "testProperty='" + testProperty + "\'" +
                ", outFile='" + outFile + '\'' +
                ", info=" + info +
                ", other=" + otherString.toString() +
                '}';
    }

    static class InfoModel {
        private String username;
        private String email;

        @Inject
        public InfoModel() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "InfoModel{" +
                    "username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


}
