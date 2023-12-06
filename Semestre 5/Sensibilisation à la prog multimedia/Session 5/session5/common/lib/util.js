// Fonction générique pour créer un slider avec un label
        function createSliderWithLabel2 (parentElement, minValue, maxValue, initialValue, step ,label, callback) {
            // Crée un label
            const labelElement = document.createElement('label');
            labelElement.textContent = label ;
            parentElement.appendChild(labelElement);

            // Crée un slider
            const slider = document.createElement('input');
            slider.type = 'range';
            slider.min = minValue;
            slider.max = maxValue;
            slider.value = initialValue;
            slider.step = step;
            

            const valueSpan = document.createElement('span');
            valueSpan.textContent = initialValue;

            // Mettre à jour la valeur affichée et appeler le callback lorsque le slider change
            slider.addEventListener('input', function () {
                valueSpan.textContent = slider.value;
                callback(parseFloat(slider.value));
            });

            parentElement.appendChild(slider);
            parentElement.appendChild(valueSpan);
        }

        