### STAGE 1: Build ###

# We label our stage as ‘builder’
FROM node:alpine as builder

COPY package.json package-lock.json ./

## Storing node modules on a separate layer will prevent unnecessary npm installs at each build

RUN npm ci && mkdir /emprestimo-digital-frontend && mv ./node_modules ./emprestimo-digital-frontend

WORKDIR /emprestimo-digital-frontend

COPY . .

## Build the angular app in production mode and store the artifacts in dist folder

RUN npm run ng build -- --prod --output-path=dist


### STAGE 2: Setup ###

FROM nginx:alpine

## Copy our default nginx config
COPY nginx/default.conf /etc/nginx/conf.d/

## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*

## From ‘builder’ stage copy over the artifacts in dist folder to default nginx public folder
COPY --from=builder /emprestimo-digital-frontend/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]