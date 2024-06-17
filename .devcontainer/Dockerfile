#-------------------------------------------------------------------------------------------------------------
# Copyright (c) Microsoft Corporation. All rights reserved.
# Licensed under the MIT License. See https://go.microsoft.com/fwlink/?linkid=2090316 for license information.
#-------------------------------------------------------------------------------------------------------------

# Update the VARIANT arg in devcontainer.json to pick an Ubuntu version: 20.04, 18.04
# To fully customize the contents of this image, use the following Dockerfile instead:
# https://github.com/microsoft/vscode-dev-containers/tree/v0.122.1/containers/ubuntu/.devcontainer/base.Dockerfile
ARG VARIANT="ubuntu-24.04"
FROM mcr.microsoft.com/vscode/devcontainers/base:${VARIANT}

# ** [Optional] Uncomment this section to install additional packages. **
#


# RUN curl -m 1 http://host.docker.internal:3142/ && echo 'Acquire::http { Proxy "http://host.docker.internal:3142"; };' >> /etc/apt/apt.conf.d/01proxy

RUN apt-get update \
    && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends openjdk-17-jdk git maven make clang clang-format valgrind vim

RUN echo "PATH=$PATH:/workspaces/ec-lang" >> /root/.bashrc

COPY vsc-grammar/ec-lang-support /root/.vscode-server/extensions/ec-lang-support

RUN wget https://download.jetbrains.com/idea/ideaIC-2022.1.1.tar.gz
RUN tar -zxvf ideaIC-*.tar.gz
RUN mkdir /opt/idea/
RUN chmod 777 /opt/idea/
RUN mv idea-*/* /opt/idea/
RUN ln -sf /opt/idea/bin/idea.sh /usr/local/bin/ij
RUN usermod -aG ubuntu vscode

USER ubuntu
