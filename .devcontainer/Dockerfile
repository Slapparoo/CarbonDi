#-------------------------------------------------------------------------------------------------------------
# Copyright (c) Microsoft Corporation. All rights reserved.
# Licensed under the MIT License. See https://go.microsoft.com/fwlink/?linkid=2090316 for license information.
#-------------------------------------------------------------------------------------------------------------

# Update the VARIANT arg in devcontainer.json to pick an Ubuntu version: 20.04, 18.04
# To fully customize the contents of this image, use the following Dockerfile instead:
# https://github.com/microsoft/vscode-dev-containers/tree/v0.122.1/containers/ubuntu/.devcontainer/base.Dockerfile
ARG VARIANT="20.04"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-ubuntu${VARIANT}

# ** [Optional] Uncomment this section to install additional packages. **
#


# RUN curl -m 1 http://host.docker.internal:3142/ && echo 'Acquire::http { Proxy "http://host.docker.internal:3142"; };' >> /etc/apt/apt.conf.d/01proxy

RUN apt-get update \
    && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends default-jdk git maven make clang clang-format valgrind

RUN echo "PATH=$PATH:/workspaces/ec-lang" >> /root/.bashrc

COPY vsc-grammar/ec-lang-support /root/.vscode-server/extensions/ec-lang-support


