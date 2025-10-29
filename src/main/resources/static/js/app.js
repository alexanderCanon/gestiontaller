document.addEventListener('DOMContentLoaded', () => {
    const apiBaseUrl = '/api/v1';
    const resultsContainer = document.getElementById('results');

    // Function to display results
    const displayResults = (data) => {
        resultsContainer.textContent = JSON.stringify(data, null, 2);
    };

    // Generic function to handle API requests
    const handleRequest = async (endpoint, method = 'GET', body = null) => {
        try {
            const options = {
                method,
                headers: {
                    'Content-Type': 'application/json',
                },
            };
            if (body) {
                options.body = JSON.stringify(body);
            }

            const response = await fetch(`${apiBaseUrl}/${endpoint}`, options);
            
            if (method === 'DELETE' && response.status === 204) {
                return { message: `Successfully deleted resource at ${endpoint}` };
            }

            const data = await response.json();
            if (!response.ok) {
                throw new Error(data.message || 'An error occurred');
            }
            return data;
        } catch (error) {
            return { error: error.message };
        }
    };

    // Attach event listeners to all 'Get All' buttons
    document.querySelectorAll('.controls button[data-entity]').forEach(button => {
        button.addEventListener('click', async () => {
            const entity = button.dataset.entity;
            const data = await handleRequest(entity);
            displayResults(data);
        });
    });

    // Attach event listeners to all forms
    document.querySelectorAll('form[data-entity]').forEach(form => {
        form.addEventListener('submit', async (e) => {
            e.preventDefault();
            const entity = form.dataset.entity;
            const action = form.dataset.action;
            
            const formData = new FormData(form);
            const body = {};
            let id = null;

            // Special handling for ID fields (plate for vehicles, dpi for users)
            const idKey = (entity === 'vehicles' || entity === 'users') ? (entity === 'vehicles' ? 'plate' : 'dpi') : 'id';

            for (let [key, value] of formData.entries()) {
                if (key === idKey && (action === 'update' || action === 'delete')) {
                    id = value;
                } else if (value) { // Only include non-empty fields
                    // Handle checkbox
                    if (form.elements[key] && form.elements[key].type === 'checkbox') {
                        body[key] = form.elements[key].checked;
                    } else {
                        body[key] = value;
                    }
                }
            }

            let endpoint = entity;
            let method = 'GET';

            switch (action) {
                case 'create':
                    method = 'POST';
                    break;
                case 'update':
                    method = 'PUT';
                    endpoint = `${entity}/${id}`;
                    break;
                case 'delete':
                    method = 'DELETE';
                    endpoint = `${entity}/${id}`;
                    break;
            }

            const result = await handleRequest(endpoint, method, action === 'delete' ? null : body);
            displayResults(result);

            // Refresh the list after a modification
            if (action !== 'get') {
                document.querySelector(`.controls button[data-entity='${entity}']`).click();
            }
        });
    });
});

