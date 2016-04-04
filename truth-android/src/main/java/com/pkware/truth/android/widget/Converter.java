/*
 * Copyright 2016 PKWARE, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Converter {

  @TargetApi(Build.VERSION_CODES.KITKAT)
  public static void main(String[] args) throws IOException {
    for (String packageName : new String[]{"widget"}) {
      File root = new File("truth-android-recyclerview-v7/src/main/java/org/assertj/android/recyclerview/v7/api/" + packageName);
      File[] toConvert = root.listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String filename) {
          return filename.endsWith("Assert.java");
        }
      });

      for (File file : toConvert) {
        String targetDir = "truth-android-recyclerview-v7/src/main/java/com/pkware/truth/android/recyclerview/v7/" + packageName + "/";
        new File(targetDir).mkdirs();
        String pathToNewFile = file.getName();
        pathToNewFile = targetDir + pathToNewFile.substring(0, pathToNewFile.indexOf("Assert.java")) + "Subject.java";
        boolean hitPackage = false;
        boolean isAbstract = false;
        String className = file.getName();
        className = className.substring(0, className.indexOf(".java"));
        String newClassName = className.substring(0, className.indexOf("Assert")) + "Subject";
        String subject = newClassName.substring(0, newClassName.indexOf("Subject"));
        try (
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(new File(pathToNewFile))) {

          writer.print("/*\n" +
              " * Copyright 2016 PKWARE, Inc.\n" +
              " *\n" +
              " * Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
              " * you may not use this file except in compliance with the License.\n" +
              " * You may obtain a copy of the License at\n" +
              " *\n" +
              " *    http://www.apache.org/licenses/LICENSE-2.0\n" +
              " *\n" +
              " * Unless required by applicable law or agreed to in writing, software\n" +
              " * distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
              " * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
              " * See the License for the specific language governing permissions and\n" +
              " * limitations under the License.\n" +
              " */\n");
          while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains("package")) {
              line = line.replace("package org.assertj.android.recyclerview.v7.api", "package com.pkware.truth.android.recyclerview.v7");
              hitPackage = true;
            } else if (!hitPackage) {
              continue;
            }

            if (line.contains("public class")) {
              writer.println("/**");
              writer.println(" * Propositions for {@link " + subject + "} subjects.");
              writer.println(" */");
            } else if (line.contains("public final class")) {
              writer.println(" * Propositions for {@link " + subject + "} subjects.");
              writer.println(" * <p/>");
            }

            if (line.contains("class Abstract")) {
              isAbstract = true;
            }

            if (line.trim().equals("isNotNull();")) {
              continue;
            }

            if (line.contains("public " + className + "(" + subject)) {
              // Is constructor. Skip this line and the next. Print our constructor instead
              scanner.nextLine();
              writer.println("  protected " + newClassName + "(FailureStrategy failureStrategy, " + subject + " subject) {");

              if (isAbstract) {
                line = "    super(failureStrategy, subject);";
              } else {
                writer.println("    super(failureStrategy, subject);");
                writer.println("  }");
                writer.println();
                writer.println("  public static SubjectFactory<" + newClassName + ", " + subject + "> type() {");
                writer.println("    return new SubjectFactory<" + newClassName + ", " + subject + ">() {");
                writer.println("      @Override");
                writer.println("      public " + newClassName + " getSubject(FailureStrategy fs, " + subject + " that) {");
                writer.println("        return new " + newClassName + "(fs, that);");
                writer.println("      }");
                line = "    };";
              }
            }

            if (line.contains("Assertions for")) {
              continue;
            }

            line = line.replace(className, newClassName);

            line = line.replace(") //", ")");

            if (line.contains("org.assertj.core.api.Assertions")) {
              writer.println("import com.google.common.truth.FailureStrategy;");
              writer.println("import com.google.common.truth.SubjectFactory;");
              line = line.replace("org.assertj.core.api.Assertions", "com.google.common.truth.Truth");
            }

            if (line.contains("return myself;")) {
              writer.println("    //noinspection unchecked");
              line = "    return (S) this;";
            }

            line = line.replace("actual.", "getSubject().");
            line = line.replace("Assert<", "Subject<");
            if (line.contains("(float ")) {
              line = line.replace(") {", ", float tolerance) {");
            } else if (line.contains("double ")) {
              line = line.replace(") {", ", double tolerance) {");
            }
            line = line.replace("AbstractSubject", "Subject");

            writer.println(line);
          }
        }

//      file.delete();
      }
    }
  }
}
